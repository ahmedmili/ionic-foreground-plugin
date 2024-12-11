
import { registerPlugin } from '@capacitor/core';
import type { ForegroundPlugin as ForegroundPluginType} from './definitions';

const ForegroundPlugin = registerPlugin<ForegroundPluginType>('ForegroundPlugin'); // Register the plugin instance

export * from './definitions';
export { ForegroundPlugin }; // Export the runtime plugin instance
